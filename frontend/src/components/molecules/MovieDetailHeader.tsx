"use client"
import { IMovieHeaderDetail } from '@/common/interface-movie'
import { Box, Button, Typography, useMediaQuery, useTheme } from '@mui/material'
import Image from 'next/image'
import CalificationStar from '../atoms/CalificationStar'

interface Props extends IMovieHeaderDetail {
  smallComponent?: boolean
}

const HeaderDetail = ({ smallComponent, title, runtime, releaseDate, vote_average, vote_count, threeD }: Props) => {
  const theme = useTheme()
  const isMatch = useMediaQuery(theme.breakpoints.down("md"))

  return (
    <Box width={"100%"} display="flex" padding="20px 20px 10px" gap="20px"
      justifyContent={{ md: "space-between" }} flexDirection={smallComponent ? "column" : { xs: "column", md: "row" }}
      bgcolor={{ xs: "var(--lightBlack)", sm: "transparent" }} borderRadius={{ xs: "0 0 16px 16px", sm: "0" }} >

      {!smallComponent && (
        <Box overflow={"hidden"}>
          <Typography title={title} variant="body1" lineHeight={"30px"} fontSize={26} fontWeight={700}
            color={"var(--light-white-color)"} noWrap={isMatch}>
            {title}
          </Typography>

          <Typography variant="body2" marginTop={1} lineHeight={"21px"} fontSize={16} fontWeight={400}
            color={"var(--light-gray-color)"}>
            {threeD ?? runtime} ● {releaseDate}
          </Typography>
        </Box>
      )}
      <Box display="flex" flexDirection="column" gap="12px">

        <Box display={"flex"} alignItems={"center"} gap="5px">
          <Typography variant="caption" component={"legend"} fontSize={16} lineHeight={"20px"}
            fontWeight={700} color={"var(--white)"}>
            Calificación
          </Typography>

          <Image width={16} height={16} alt="star-icon" src={"/images/cards/star.svg"} />

          <Typography variant="caption" component={"div"} fontSize={16} lineHeight={"20px"}
            fontWeight={700} color={"var(--white)"}>
            {vote_average}
          </Typography>

          <Typography variant="caption" component={"span"} fontSize={12} fontWeight={400} lineHeight={"18px"}
            color={"var(--gray-color)"}>
            ({vote_count})
          </Typography>
        </Box>

        <Box display="flex" alignItems="center" justifyContent="space-between">
          <CalificationStar vote_average={vote_average} />
          <Button type="button" variant="outlined" color="warning">
            <Image
              src={"/images/polygon.svg"}
              alt="play-icon"
              width={16}
              height={16}
              style={{ marginRight: "5px" }}
            />
            <Typography component="span" variant="body2" sx={{ display: { xs: "block", sm: "none", md: "block" } }}>
              trailer
            </Typography>
          </Button>
        </Box>

      </Box>
    </Box>
  )
}

export default HeaderDetail  