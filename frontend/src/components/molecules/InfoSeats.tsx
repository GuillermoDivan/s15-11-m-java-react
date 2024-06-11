import { Box, Typography } from '@mui/material'
import Image from 'next/image'
import React from 'react'

const infoSeats = [
    { src: "seat-white", name: "disponible" },
    { src: "seat-red", name: "ocupado" },
    { src: "seat-yellow", name: "seleccionado" },
]

const InfoSeats = () => {
    return (
        <Box display="flex" gap={2} px={1}
            flexWrap={"wrap"}
            justifyContent="space-between"
        >
            {infoSeats.map(({ src, name }) => (
                <Box key={name} display="flex" alignItems={"center"} gap={1}>
                    <Typography
                        width={{ xs: "104px", sm: "fit-content" }}
                        variant="caption"
                        textTransform={"uppercase"}
                        fontWeight={"bold"}
                        color={"var(--light-gray-color)"}
                    >
                        {name}:
                    </Typography>
                    <Image
                        width={24}
                        height={24}
                        src={`/images/seats/${src}.png`}
                        alt={name}
                    />
                </Box>
            ))}
        </Box>
    )
}

export default InfoSeats