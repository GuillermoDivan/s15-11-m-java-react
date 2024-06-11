"use client"
import { useEffect, useState } from "react";
import AmountSeats from "../molecules/AmountSeats";
import { UseMoviefunction } from "@/store/movie-function-store";
import { sortSeats } from "@/utils/utils";
import { ISeat } from "@/common/interface-functionDetail";
import { shallow } from "zustand/shallow";
import TotalSeats from "../molecules/TotalSeats";
import InfoSeats from "../molecules/InfoSeats";

const Seats = () => {
    const [totalseats, setTotalSeats] = useState<ISeat[]>([]);

    const { movieFunctionDetail, selectedSeats, handleSeatClick } = UseMoviefunction(state => ({
        movieFunctionDetail: state.movieFunctionDetail,
        selectedSeats: state.selectedSeats,
        handleSeatClick: state.handleSeatClick
    }), shallow);



    useEffect(() => {
        if (movieFunctionDetail) {
            const sortedSeats = sortSeats(movieFunctionDetail.seatsList);
            setTotalSeats(sortedSeats);
        }
    }, [movieFunctionDetail]);


    return (
        <>
            <AmountSeats />

            <InfoSeats />

            {movieFunctionDetail &&
                <TotalSeats
                    totalseats={totalseats}
                    selectedSeats={selectedSeats}
                    onSeatClick={handleSeatClick}
                />
            }

        </>
    );
}

export default Seats;
