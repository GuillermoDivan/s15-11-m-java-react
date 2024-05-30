import { createWithEqualityFn } from 'zustand/traditional'

interface IPaginations {
    page: number,
    setPage: (newValue: number) => void,
    totalPages: number,
    setTotalPages: (newValue: number) => void
}

export const useMoviesPagination = createWithEqualityFn<IPaginations>(set => ({
    page: 1,
    setPage: (value) => set({ page: value }),
    totalPages: 1,
    setTotalPages: (value) => set({ totalPages: value }),
}))