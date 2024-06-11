import HeaderDetail from "../molecules/MovieDetailHeader"
import { Box } from "@mui/material"
import MovieImageDetail from "../atoms/MovieImageDetail"
import MovieDetailContent from "../molecules/MovieDetailContent"
import { FC } from "react"
import { IMovie } from "@/common/interface-movie"

const AVERAGE = 4.5

const MovieDetail: FC<{ movie: IMovie, smallComponent?: boolean }> = ({ movie, smallComponent }) => {
    return (<>
        <Box display={smallComponent ? { lg: "block", md: "block", sm: "none", xs: "none" } : "block"} margin={smallComponent ? 0 : "1.5rem auto"}>
            <Box sx={{
                width: smallComponent ? "93%" : { xs: "93%", sm: "96%", md: "90%" }, margin: "1rem auto", borderRadius: "16px",
                display: "flex", bgcolor: { sm: "var(--lightBlack)" },
                flexDirection: smallComponent ? "column" : { xs: "column", sm: "row" }, transition: "width ease .3s"
            }}>
                <MovieImageDetail imagePath={movie?.image} />

                <Box width={smallComponent ? "100%" : { xs: "100%", sm: "57%", md: "calc(100% - 290px)" }} display="flex"
                    gap={smallComponent ? "1rem" : { xs: "1rem", sm: "0" }} flexDirection={"column"}
                    justifyContent={{ md: "space-evenly", sm: "space-between" }}>

                    <HeaderDetail
                        releaseDate={movie.releaseDate || "26.7.2024"}
                        title={movie.title || "Deadpool And Wolverine"}
                        runtime="1h30m"
                        threeD={movie.threeD ? "3D" : false}
                        vote_average={AVERAGE}
                        vote_count={1.612}
                        smallComponent={smallComponent}
                    />

                    {smallComponent ? "" :
                        <MovieDetailContent
                            genre={movie.genre || ["acción", "comedia"]}
                            censorship={undefined}
                            certification={movie.adult ? "+18" : "ATP"}
                            original_language={movie.subtitle ? "INGLÉS" : "ESPAÑOL"}
                            description={movie.description}
                        />
                    }

                </Box>
            </Box>
        </Box>


    </>)
}

export default MovieDetail