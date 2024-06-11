
import { Box, Typography } from "@mui/material"
import CalificationStar from "../atoms/CalificationStar"
const lista = [
    { puntaje: 4.5, usuario: "Chino Maidana", comentario: "Que pelicula fascinante!", fecha: "08/06/24" },
    { puntaje: 3, usuario: "Noland Nordinelli", comentario: "Totalmente inesperado, vaya final!", fecha: "08/06/24" },
    { puntaje: 2.5, usuario: "Debora García", comentario: "No fue lo que esperaba, pero estoy satisfecha.", fecha: "10/06/24" },
]

const ComentariosFicticios = () => {
    return (<>
        <Typography color={"var(--light-gray-color)"} textAlign={"center"} variant={"caption"} component={"div"}>
            Caja de comentarios
        </Typography>

        {lista.map(({ puntaje, usuario, comentario, fecha }) => (
            <Box key={usuario} width={"80%"} margin={"1rem auto 2rem"} bgcolor={"var(--lightBlack)"} boxShadow={"0 0 5px var(--yellow)"} p={2}
                borderRadius={3}
            >
                <Box display="flex" justifyContent={"space-between"} alignItems={"center"}>
                    <Typography color={"var(--yellow)"} textAlign={"center"} variant={"h5"} component={"h5"} mb={1}>
                        {usuario}
                    </Typography>

                    <CalificationStar vote_average={puntaje} />
                </Box>

                <Typography component={"p"} py={1} pl={2} fontSize={"18px"}>
                    {comentario}
                </Typography>

                <Typography variant={"caption"} component={"div"} textAlign={"end"}>
                    {fecha}
                </Typography>
            </Box >
        ))}
        <Box borderRadius={3} width={"fit-content"} mx={"auto"} alignContent="center" p={2.5} mb={4} bgcolor={"var(--lightBlack)"}>
            <Typography color={"var(--yellow)"} textAlign={"center"} variant={"h6"} component={"h6"}>
                Para comentar debes ver la pelicula!
            </Typography>
        </Box>
    </>)
}

export default ComentariosFicticios