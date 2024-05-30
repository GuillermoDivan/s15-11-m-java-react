"use client"
import { useEffect, useState } from "react";
import MovieCard from "../molecules/MovieCard";
import { useRouter } from "next/navigation";
import { fetchData } from "@/utils/fetchData";
import { filterMovies, convertGenre, convertImagePath, filterLastMovies } from "@/utils/fc-movies";
import { useMoviesPagination } from "@/store/cspagination-store";
import { shallow } from "zustand/shallow";
import { demoMoviesState } from "@/store/movies-store";


const ComingSoon = () => {
    const router = useRouter();
    const { demoSetMovies } = demoMoviesState((state: any) => ({ demoSetMovies: state.setMovies }))

    const { page, setTotalPages } = useMoviesPagination(state => (
        { page: state.page, setTotalPages: state.setTotalPages }
    ), shallow)

    const [movies, setMovies] = useState([]);

    const ITEMS_PER_PAGES = 15;
    const handleClick = (id: string) => router.push("/pelicula/" + id);

    useEffect(() => {
        const fetchDataAndSetState = async () => {
            const res = await fetchData("movie/list", "GET");
            const filteredMovies = filterMovies(res);

            const totalMovies = filteredMovies.length;
            const totalPages = Math.ceil(totalMovies / ITEMS_PER_PAGES);

            setTotalPages(totalPages);
            setMovies(filteredMovies);

            //  LO DE ABAJO ES MOMENTANEO
            const demoMovies: any = filterLastMovies(res)
            console.log(demoMovies);

            demoSetMovies(demoMovies)
        };

        fetchDataAndSetState();
    }, []);



    const startIndex = (page - 1) * ITEMS_PER_PAGES;
    const endIndex = startIndex + ITEMS_PER_PAGES;
    const currentMovies = movies.slice(startIndex, endIndex);

    return (
        <>
            {currentMovies.map((data, i) => (
                <MovieCard key={i} isComingSoon={true} handleClick={handleClick}
                    id={data.id}
                    nameMovie={data.title}
                    textCalendar={data.releaseDate}
                    textVideo={convertGenre(data.genre)}
                    imagePath={convertImagePath(data.description, data.image)}
                />
            ))}
        </>
    );
};


export default ComingSoon