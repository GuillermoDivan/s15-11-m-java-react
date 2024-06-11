"use client"
import { Box, Typography } from "@mui/material"
import BoxButtonSvg from "../atoms/BoxButtonSvg"
import { priceFormat } from "@/utils/utils"
import { UseMoviefunction } from "@/store/movie-function-store"
import { shallow } from "zustand/shallow"

const pricePerSeat = 3000

const AmountSeats = () => {
    const { numberSeats, setNumberSeats, removeLastSelectedSeat } = UseMoviefunction(state => ({
        numberSeats: state.numberSeats,
        setNumberSeats: state.setNumberSeats,
        removeLastSelectedSeat: state.removeLastSelectedSeat,
    }), shallow);

    const addSeat = () => numberSeats < 10 && setNumberSeats(numberSeats + 1);
    const removeSeat = () => {
        if (numberSeats > 1) {
            setNumberSeats(numberSeats - 1);
            removeLastSelectedSeat();
        }
    };

    return (
        <Box color={"var(--light-white-color)"}
            sx={{
                display: "flex", justifyContent: "space-between", alignItems: "center",
                px: 1, flexDirection: { xs: "column", sm: "row" }
            }}>
            <Box sx={{ display: "flex", gap: "16px", alignItems: "center", justifyContent: { xs: "space-between", sm: "flex-start" }, width: { xs: "90%" } }}>
                <Typography variant="h6" component={"p"}>
                    Butacas:
                </Typography>
                <Box display="flex" flexDirection={{ xs: "column", sm: "row" }} alignItems={"center"}>
                    <Box display="flex" gap="6px" alignItems={"center"}>
                        <BoxButtonSvg
                            path={"/images/seats/remove.svg"}
                            sizesInPx={{ width: 24, height: 24 }}
                            handleClick={removeSeat}
                            alt="remove-seat"
                            sxBox={{ width: "fit-content" }}
                            sxButton={{ minWidth: "34px" }}
                        />
                        <Typography variant="h6" component={"p"}>
                            {numberSeats}
                        </Typography>
                        <BoxButtonSvg
                            path={"/images/seats/add.svg"}
                            sizesInPx={{ width: 24, height: 24 }}
                            handleClick={addSeat}
                            alt="add-seat"
                            sxBox={{ width: "fit-content" }}
                            sxButton={{ minWidth: "34px" }}
                        />
                    </Box>
                    {numberSeats >= 10 &&
                        <Typography variant="caption" textAlign={"center"} component={"span"} color={"#ff7070"}>
                            Máx. 10
                        </Typography>
                    }
                </Box>
            </Box>

            <Box sx={{ display: "flex", gap: "16px", alignItems: "center", justifyContent: { xs: "space-between", sm: "flex-end" }, width: { xs: "90%" } }}>
                <Typography variant="h6" component={"p"}>
                    Precio:
                </Typography>
                <Typography variant="h6" component={"p"}>
                    {priceFormat(pricePerSeat * numberSeats)}
                </Typography>
            </Box>
        </Box>)
}

export default AmountSeats