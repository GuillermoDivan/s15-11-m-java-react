import { CardActionArea, Card, CardContent, Typography, Box } from '@mui/material';
import BoxIconWithText from '../atoms/BoxIconWithText';
import Image from 'next/image';

interface PropsMovieCard {
  id?: string,
  isComingSoon?: boolean,
  handleClick?: (id: string) => void,
  nameMovie?: string,
  imagePath?: string,

  textStar?: string,
  textVideo?: string,
  textClock?: string,
  textCalendar?: string,
}

const MovieCard = ({ id, nameMovie, imagePath, isComingSoon, handleClick, textStar, textVideo, textCalendar, textClock }: PropsMovieCard) => {
  return (
    <Card component="figure" onClick={() => { handleClick && handleClick(id || "#") }} sx={{
      width: { xs: 180, sm: 192 },
      height: 360,
      bgcolor: "var(--lightBlack)",
    }}

    >
      <CardActionArea>
        <Image
          width={192}
          height={240}
          alt={nameMovie || "deadpool"}
          src={imagePath || "/images/deadpool-3.jpg"}
          style={{ objectFit: "cover" }}
          sizes="(max-width: 600px) 100%"
        />
        <CardContent sx={{ padding: "7px", display: "flex", flexDirection: "column", justifyContent: "space-evenly", height: 120 }}>
          <Typography maxHeight={"40px"} maxWidth={"95%"} gutterBottom variant="caption" overflow={"hidden"} textOverflow={"ellipsis"} component="figcaption" color="var(--yellow)" fontWeight={700} fontSize={16} lineHeight={"20px"} m={0}>
            {nameMovie || "Deadpool and Wolverine"}
          </Typography>
          <Box maxHeight={61}>
          {isComingSoon
            ? <BoxIconWithText leftText={true} typographyProps={{ color: "var(--gray-color)", fontSize: "15px" }} text={textCalendar || "28.06.2024"} svgPath="/images/cards/calendar.svg" />
            : <>
              <BoxIconWithText leftText={true} typographyProps={{ color: "var(--gray-color)", fontSize: "15px" }} text={textStar || "4.8"} svgPath="/images/cards/star.svg" />
              <BoxIconWithText leftText={true} typographyProps={{ color: "var(--gray-color)", fontSize: "15px" }} text={textClock || "1 hora, 30 minutos."} svgPath="/images/cards/clock.svg" />
            </>}

          <BoxIconWithText leftText={true} typographyProps={{ color: "var(--gray-color)", fontSize: "15px" }} text={textVideo || "Accion, Comedia."} svgPath="/images/cards/video.svg" />
            </Box>

        </CardContent>
      </CardActionArea>
    </Card>
  );
}

export default MovieCard