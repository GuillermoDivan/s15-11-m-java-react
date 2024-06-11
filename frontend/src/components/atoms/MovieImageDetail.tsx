import { IMovieImage } from "@/common/interface-movie"
import { Box } from "@mui/material"
import { FC } from "react"

const MovieImagenDetail: FC<IMovieImage> = ({ imagePath }) => {
    return (
        <Box
            src={imagePath || "/images/deadpool-3.jpg"}
            component="img"
            loading="lazy"
            alt="Poster-Image"
            height={{ xs: 250, sm: "auto", md: 363 }}
            width={{ xs: "100%", sm: "43%", md: 290 }}
            sx={{
                position: "relative", overflow: "hidden",
                borderRadius: { sm: "16px 0 0 16px" },
                objectFit: "cover",
            }}
        />)
}

export default MovieImagenDetail