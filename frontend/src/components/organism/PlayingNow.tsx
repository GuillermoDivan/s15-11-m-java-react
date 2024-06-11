"use client"
import MovieCard from "../molecules/MovieCard"
import { useRouter, usePathname } from "next/navigation"
import { useEffect } from "react"
import { convertGenre } from "@/utils/fc-movies"
import { IMovie } from "@/common/interface-movie"
import { useMoviesPagination } from "@/store/cspagination-store"
import { shallow } from "zustand/shallow"

const PlayingNow = ({ movies }: { movies: IMovie[] }) => {
    const router = useRouter()
    const ITEMS_PER_PAGES = 10
    const { page, setTotalPages } = useMoviesPagination(state => (
        { page: state.page, setTotalPages: state.setTotalPages }
    ), shallow)

    useEffect(() => {
        const totalMovies = movies.length;
        const totalPages = Math.ceil(totalMovies / ITEMS_PER_PAGES);
        setTotalPages(totalPages);
    }, []);
    const currentPath = usePathname();
    const handleClick = (id: string) => router.push(`${currentPath}/${id}`);

    const startIndex = (page - 1) * ITEMS_PER_PAGES;
    const endIndex = startIndex + ITEMS_PER_PAGES;
    const currentMovies = movies.slice(startIndex, endIndex);

    return <>
        {currentMovies.map((data: IMovie, i: number) => (
            <MovieCard key={i} handleClick={handleClick}
                id={data.id}
                nameMovie={data.title}
                textVideo={convertGenre(data.genre)}
                imagePath={data.image}
            />
        ))}
    </>
}

export default PlayingNow