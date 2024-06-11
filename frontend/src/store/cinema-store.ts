import { createWithEqualityFn } from 'zustand/traditional';
import { persist, createJSONStorage } from 'zustand/middleware'
import { IMovie } from '@/common/interface-movie';

export interface ICinema {
    city: string;
    direction: string;
    id: string;
    name: string;
    state: string;
}

interface ICinemaState {
    currentCity: string;
    setCurrentCity: (newValue: string) => void;

    currentCinema: false | ICinema;
    setCurrentCinema: (newValue: ICinema | false) => void,

    moviesByCinema: false | IMovie[],
    setMoviesByCinema: (newValue: IMovie[] | false) => void
}


export const useCinemaStore = createWithEqualityFn<ICinemaState>()(
    persist(
        (set, get) => ({
            currentCity: "empty",
            setCurrentCity: (newValue) => {
                const { currentCity } = get()
                if (newValue == currentCity && newValue == "empty") return;
                set(() => ({ currentCity: newValue }))
            },

            currentCinema: false,
            setCurrentCinema: (newValue) => {

                const { currentCinema } = get()
                if (newValue == currentCinema) return;
                set(() => ({ currentCinema: newValue }))
            },

            moviesByCinema: false,
            setMoviesByCinema: (newValue) => set(() => ({ moviesByCinema: newValue }))
        }),
        {
            name: "cinema",
            storage: createJSONStorage(() => sessionStorage),
        },
    ),
)