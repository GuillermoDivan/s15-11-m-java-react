import { CardActionArea, Card, CardMedia, CardContent, Typography } from '@mui/material';
import BoxIconWithText from '../atoms/BoxIconWithText';

const CardNowPlaying = () => {
  return (
    <Card sx={{
      width: 310,
      height: 548,
      bgcolor: "var(--lightBlack)",
      color: "var(--white)",
      textAlign: "center",
      borderRadius: "16px"
    }}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="440"
          image="/images/deadpool-3.jpg"
          alt="Deadpool 3"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            Deadpool And Wolverine
          </Typography>

          <Typography variant="subtitle2" color="var(--gray-color)">
            1h30min • Acción/Comedia
          </Typography>

          <BoxIconWithText text={"4.8"} svgPath="images/cards/star.svg" />

        </CardContent>
      </CardActionArea>
    </Card>
  );
}

export default CardNowPlaying