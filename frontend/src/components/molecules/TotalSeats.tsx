import { FC } from 'react';
import { ISeat } from '@/common/interface-functionDetail';
import { Box, Button, Grid, Typography } from '@mui/material';
import Image from 'next/image';

interface TotalSeatsProps {
    totalseats: ISeat[];
    selectedSeats: string[];
    onSeatClick: (seatNumber: string) => void;
}

const TotalSeats: FC<TotalSeatsProps> = ({ totalseats, selectedSeats, onSeatClick }) => {
    const getSeatImage = (seat: ISeat) => {
        if (selectedSeats.includes(seat.seatNumber)) {
            return "seat-yellow";
        }
        switch (seat.seatEnum) {
            case "OCCUPIED":
                return "seat-red";
            default:
                return "seat-white";
        }
    };

    return (
        <Grid container
            width={{ xs: "100%", sm: "85%", md: "70%", lg: "65%" }}
            spacing={1}
            columns={7}
            mt={5} py={4} px={{ sx: 1, sm: 3 }} borderRadius={4}
            mx={"auto"}
            bgcolor={"var(--lightBlack)"}
            alignItems={"center"}>
            <Grid item xs={7} alignContent={"center"} mb={4}>
                <Box sx={{
                    margin: "auto",
                    width: "100%",
                    height: "4px",
                    borderRadius: "50%",
                    bgcolor: "var(--light-white-color)"
                }}
                />
                <Typography color="var(--light-gray-color)" variant={"h6"} component={"div"} textAlign={"center"} fontWeight={"bold"}>
                    PANTALLA
                </Typography>
            </Grid>
            {totalseats.map(data => (
                <Grid item xs={1} key={data.seatNumber}
                    mt={1} justifyContent={"center"} sx={{ padding: "0!important" }}>
                    <Button
                        onClick={() => onSeatClick(data.seatNumber)}
                        disabled={data.seatEnum === "OCCUPIED"}
                        variant="outlined" color="warning"
                        sx={{
                            display: "flex", flexDirection: "column", alignItems: "center",
                            padding: "5px!important", minWidth: "50px!important", border: "none!important",
                        }}
                    >
                        <Image
                            width={24}
                            height={24}
                            src={`/images/seats/${getSeatImage(data)}.png`}
                            alt={data.seatNumber}
                        />
                        <Typography color="var(--light-gray-color)" variant={"caption"} component={"div"} textAlign={"center"} title={"Butaca " + data.seatNumber}>
                            {data.seatNumber}
                        </Typography>
                    </Button>
                </Grid>
            ))}
        </Grid>
    );
}

export default TotalSeats;
