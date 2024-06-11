import { IMovieInfoDetail } from '@/common/interface-movie'
import { convertGenre } from '@/utils/fc-movies'
import { Box, Typography } from '@mui/material'
import { FC } from 'react'

interface ArrayInfo {
  name: string,
  value: string
}

const MovieInfoDetail: FC<IMovieInfoDetail> = (movieInfoDetail) => {
  const arrayInfo: ArrayInfo[] = [
    { name: "género", value: convertGenre(movieInfoDetail.genre) },
    { name: "Idioma", value: movieInfoDetail.original_language ?? "" },
    { name: "clasificación", value: (movieInfoDetail.certification || movieInfoDetail.censorship) ?? "" },
  ]

  return (
    <Box padding="10px 20px" display={"flex"} alignItems={"center"}
      flexDirection={{ xs: "column", md: "row" }}
      justifyContent="space-between" gap="10px"
    >
      {arrayInfo.map((item, index) => (
        <Box key={index} display="flex" justifyContent={"space-between"} gap="5px"
          width={{ xs: "100%", md: "auto" }} alignItems={"center"}
          sx={{
            "& > span": {
              textTransform: "capitalize",
              width: { xs: "50%", md: "auto" },
              fontSize: "15px", lineHeight: "21px",
            }
          }}
        >
          <Typography component={"span"} variant="subtitle1" color="var(--light-gray-color)"
            fontWeight={400}>
            {item.name}:
          </Typography>
          <Typography component={"span"} variant="body1" color="var(--light-white-color)"
            fontWeight={700}>
            {item.value}
          </Typography>
        </Box>
      ))}
    </Box >
  )
}

export default MovieInfoDetail