"use client"
import IFunctionDetail from '@/common/interface-functionDetail'
import { Button, Container, Typography, Grow, Grid, Box } from '@mui/material'
import { FC, useEffect, useState } from 'react'
import GridOption from '../atoms/GridOption'
import { UseMoviefunction } from '@/store/movie-function-store'
import { shallow } from 'zustand/shallow'
import { useRouter, usePathname } from 'next/navigation'
import { useCinemaStore } from '@/store/cinema-store'


const SelectRom: FC<{ listFunctionDetail: IFunctionDetail[] }> = ({ listFunctionDetail }) => {
    const router = useRouter()
    const currentPath = usePathname()

    const [showMsg, setShowMsg] = useState(false)

    const [isSelectingRoom, setIsSelectingRoom] = useState(false)
    const [groupedByDay, setGroupedByDay] = useState<Record<string, IFunctionDetail[]>>({})
    const { currentCinema } = useCinemaStore(state => ({ currentCinema: state.currentCinema }), shallow)
    const { setMovieFunctionDetail, clearStore } = UseMoviefunction(state => ({
        setMovieFunctionDetail: state.setMovieFunctionDetail,
        clearStore: state.clearStore
    }), shallow)

    const handleSelectState = () => {
        setIsSelectingRoom(!isSelectingRoom)
        showMsg && setShowMsg(false)
    }
    const handleClickOnFunction = (functionDetail: IFunctionDetail) => {
        if (!currentCinema) {
            setShowMsg(true)
            handleSelectState()
            window.scrollTo({ top: 0, behavior: "smooth" })
        } else {
            setShowMsg(false)
            clearStore()
            setMovieFunctionDetail(functionDetail);
            router.push(currentPath + "/comprar")
        }
    }


    useEffect(() => {
        const grouped: Record<string, IFunctionDetail[]> = {};
        listFunctionDetail.forEach((data) => {
            const functionDate = new Date(data.schedule);
            const functionDay = functionDate.toLocaleDateString("es-ES", { weekday: 'long', day: 'numeric', month: 'long' });
            if (!grouped[functionDay]) {
                grouped[functionDay] = [];
            }
            grouped[functionDay].push(data);
        });
        setGroupedByDay(grouped);
    }, [listFunctionDetail]);

    return <Container sx={{ mt: 2, mb: 5, textAlign: "center" }}>

        <Box sx={{ display: isSelectingRoom ? "flex" : "none", flexDirection: "column" }}>

            <Grow in={isSelectingRoom}>
                <Typography variant="h4" component="h1" p={3}>
                    Horarios
                </Typography>
            </Grow>

            <Grow in={isSelectingRoom} style={{ transformOrigin: '0 0 0' }}  {...(isSelectingRoom ? { timeout: 1000 } : {})}  >
                <Box sx={{ display: "flex", flexWrap: "wrap", justifyContent: { sm: "center", md: "space-between" } }}>
                    {Object.entries(groupedByDay).map(([day, data]) =>
                        <Box key={day}
                            flexDirection="column"
                            borderRadius={3}
                            p={2} width={{ xs: "98%", sm: "80%", md: "48%" }}
                            bgcolor={"var(--lightBlack)"}
                            mb={3}>
                            <Typography
                                variant={"h5"}
                                color={"var(--gray-color)"}
                                textTransform={"capitalize"}
                                component="h2" p={3} fontWeight={600}>
                                {day}
                            </Typography>
                            <Grid container rowSpacing={2} columnSpacing={2} mb={3}
                               alignItems={"center"}
                            >
                                {data.map((functionDetail) => {
                                    const functionTime: string = new Date(functionDetail.schedule).toLocaleTimeString("es-ES", { hour: "2-digit", minute: "2-digit" });
                                    return (
                                        <GridOption key={`${functionDetail.screenId}-${functionDetail.movieId}`}
                                            state={isSelectingRoom}
                                            handleClick={() => handleClickOnFunction(functionDetail)}
                                        >
                                            {functionTime}
                                        </GridOption>
                                    )
                                })}
                            </Grid>
                        </Box>)}
                </Box>
            </Grow>

        </Box>
        <Typography color="#ca0000f0" component={"span"} variant="h5" sx={{ display: showMsg ? "block" : "none" }} my={2.5} >
            Selecciona un cine antes de comprar la entrada
        </Typography>

        <Button variant="contained" color={isSelectingRoom ? "error" : "warning"}
            size="large" type="button" onClick={handleSelectState}>
            {isSelectingRoom ? "Cancelar" : "Comprar Entrada"}
        </Button>
    </Container>
}

export default SelectRom