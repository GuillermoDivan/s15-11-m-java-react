import { createWithEqualityFn } from 'zustand/traditional';
import IFunctionDetail from '@/common/interface-functionDetail';
import { IMovie } from '@/common/interface-movie';
import { persist, createJSONStorage } from 'zustand/middleware'

interface IMovieFcValues {
    numberSeats: number
    selectedSeats: string[],
}

interface IMovieFunction extends IMovieFcValues {
    movieFunctionDetail: false | IFunctionDetail,

    setMovieFunctionDetail: (functionDetail: false | IFunctionDetail) => void,

    setNumberSeats: (number: number) => void,

    handleSeatClick: (seatNumber: string) => void;
    removeLastSelectedSeat: () => void,

    clearStore: () => void,
}

const initialValues: IMovieFcValues = {
    numberSeats: 1,
    selectedSeats: [],
}

export const UseMoviefunction = createWithEqualityFn<IMovieFunction>()(
    persist(
        (set) => ({
            ...initialValues,
            movieFunctionDetail: false,
            setMovieFunctionDetail: (newFunction) => set(() => ({ movieFunctionDetail: newFunction })),

            setNumberSeats: (num: number) => set({ numberSeats: num }),

            handleSeatClick: (seatNumber: string) => {
                set((state) => {
                    const { selectedSeats, numberSeats } = state;
                    if (selectedSeats.includes(seatNumber)) {
                        return { selectedSeats: selectedSeats.filter(seat => seat !== seatNumber) };
                    } else if (selectedSeats.length < numberSeats) {
                        return { selectedSeats: [...selectedSeats, seatNumber] };
                    } else {
                        return { selectedSeats: [...selectedSeats.slice(1), seatNumber] };
                    }
                });
            },
            removeLastSelectedSeat: () => {
                set((state) => {
                    const { selectedSeats } = state;
                    return { selectedSeats: selectedSeats.slice(0, -1) };
                });
            },

            clearStore: () => set({ ...initialValues }),
        }),
        {
            name: "functionDetail",
            storage: createJSONStorage(() => sessionStorage),
        },
    ),
)