"use client"
import { useMoviesState, demoMoviesState } from "@/store/movies-store"
import MovieCard from "../molecules/MovieCard"
import { useRouter } from "next/navigation"
import { shallow } from "zustand/shallow"
import { useEffect } from "react"
import { convertGenre, convertImagePath } from "@/utils/fc-movies"

const PlayingNow = () => {
    const router = useRouter()
    // const { movies } = useMoviesState(state => ({ movies: state.movies }), shallow)
    const { movies } = demoMoviesState((state: any) => ({ movies: state.movies }), shallow)
    const handleClick = (id: string) => router.push("/pelicula/" + id)
    useEffect(() => {
        console.log(movies);

    }, [])

    return <>
        {movies.map((data, i) => (
            <MovieCard key={i} handleClick={handleClick}
                id={data.id}
                nameMovie={data.title}
                textVideo={convertGenre(data.genre)}
                imagePath={convertImagePath(data.description, data.image)}
            />
        ))}
        <MovieCard handleClick={handleClick} id={"1"} />
    </>
}

export default PlayingNow