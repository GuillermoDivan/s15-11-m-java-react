import { fetchData } from '@/utils/fetchData';
import { createWithEqualityFn } from 'zustand/traditional';

interface IFetchProps {
    city: "string",
    cinema: "string"
}

interface IMovie {
    id: string;
    name: string;
    image: string,
    stars: string,
    duration: string,
    genre: string,
}

interface IUseMoviesState {
    movies: IMovie[];
    setMovies: ({ city, cinema }: IFetchProps) => Promise<void>;
}

export const useMoviesState = createWithEqualityFn<IUseMoviesState>(set => ({
    movies: [],
    setMovies: async ({ city, cinema }): Promise<void> => {
        const path = "nose"
        const movies: IMovie[] = await fetchData(path, "GET", { city, cinema })
        set({ movies })
    },
}));


// MOMENTANEO
export const demoMoviesState = createWithEqualityFn(set => ({
    movies: [],
    setMovies: (newMovies: any) => {
        set({ movies: newMovies })
    }
}))