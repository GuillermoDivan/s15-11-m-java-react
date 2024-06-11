import { Box, Typography } from "@mui/material"
import { FC } from "react"

const MovieDescriptionDetail: FC<{ description: string }> = ({ description }) => {
    return (
        <Box padding="10px 20px">
            <Typography fontWeight={700} fontSize="24px" variant="subtitle1" lineHeight={"30px"} color="var(--light-white-color)">
                Descripción:
            </Typography>

            <Typography component={"p"} variant="body2" marginTop="15px" fontWeight={700} fontSize="16px" lineHeight={"26px"} color="var(--light-gray-color)">
                {description}
            </Typography>
        </Box>
    )
}

export default MovieDescriptionDetail