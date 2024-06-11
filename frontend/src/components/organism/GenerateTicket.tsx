"use client"
import { IMovie } from '@/common/interface-movie'
import { useCinemaStore } from '@/store/cinema-store'
import { UseMoviefunction } from '@/store/movie-function-store'
import { Box, Button, Typography } from '@mui/material'
import { useEffect, useState } from 'react'
import { shallow } from 'zustand/shallow'
import { useRouter } from "next/navigation"
import BuyTicketModal, { InfoItem } from '../molecules/BuyTicketModal'
import { priceFormat } from '@/utils/utils'

/*
/mp/create
FALTÓ CONECTARLO CON BACKEND POR CUESTIONES DE TIEMPO...
{
  "userId": "string",
  "movieName": "string",
  "functionDetailsId": "string",
  "seatsIds": [
    "string"
  ],
  "amountOfSeats": 0,
  "unitPrice": 0
}
*/

const GenerateTicket = ({ movie }: { movie: IMovie }) => {
    const router = useRouter()
    const [open, setOpen] = useState(false)
    const [info, setInfo] = useState<InfoItem[]>([])
    const { movieFunctionDetail, selectedSeats, numberSeats } = UseMoviefunction(state => ({
        movieFunctionDetail: state.movieFunctionDetail,
        selectedSeats: state.selectedSeats, numberSeats: state.numberSeats
    }), shallow)

    const { currentCity, currentCinema } = useCinemaStore((state) => ({
        currentCity: state.currentCity,
        currentCinema: state.currentCinema
    }))


    const dateFunction = movieFunctionDetail && new Date(movieFunctionDetail.schedule)
    const formattedDate = dateFunction ? `${dateFunction.getDate()}/${dateFunction.getMonth() + 1}/${dateFunction.getFullYear()}` : ""
    const hours = dateFunction && dateFunction.getHours()
    const minutes = dateFunction && (dateFunction.getMinutes() < 10 ? `0${dateFunction.getMinutes()}` : dateFunction.getMinutes())
    const formattedTime = `${hours}:${minutes}hs.`

    useEffect(() => {
        if (movieFunctionDetail && currentCinema) {
            setInfo([
                { name: "ciudad", value: currentCity },
                { name: "cine", value: currentCinema.name },
                { name: "dirección", value: currentCinema.direction },
                { name: "pelicula", value: movie.title },
                { name: "sala", value: movieFunctionDetail.screenId },
                { name: "día", value: formattedDate },
                { name: "hora", value: formattedTime },
                { name: "butacas", value: (selectedSeats.map(seat => seat).join(", ") + ".") },
                { name: "precio total", value: priceFormat(numberSeats * 3000) },
            ])
        }

    }, [selectedSeats])

    return (
        <>
            {currentCinema && <Box display={"flex"} justifyContent={"space-between"} flexWrap={"wrap"}>
                <Typography>
                    -  {currentCinema.name}
                </Typography>

                <Typography>
                    -  {currentCinema.direction}
                </Typography>
            </Box>}
            <Box display={"flex"} justifyContent={"space-between"} >
                <Typography>
                    {formattedDate}
                </Typography>
                -
                <Typography>
                    {formattedTime}
                </Typography>
            </Box>

            <Box>
                <Button variant="contained" fullWidth onClick={() => {
                    if (selectedSeats.length > 0) setOpen(true)
                }}
                    sx={{ mb: 2, fontWeight: 600, color: "var(--light-white-color)" }}>
                    comprar
                </Button>
                <Button variant="contained" fullWidth color="error" sx={{ fontWeight: 600, color: "var(--light-white-color)" }} onClick={() => router.back()}>cancelar</Button>
            </Box>

            <BuyTicketModal open={open} setOpen={setOpen} info={info} />
        </>
    )
}

export default GenerateTicket