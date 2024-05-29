import { Typography, Box } from "@mui/material"
import Image from "next/image"
import { FC } from "react"

interface IBoxIconWithText {
    svgPath: string,
    text: string,
}

const BoxIconWithText: FC<IBoxIconWithText> = ({ svgPath, text }) => {
    return (
        <Box component={"div"} display={"flex"} m={"5px 0"} justifyContent={"center"} textAlign={"center"} gap={"4px"} alignItems="center">
            <Image
                height={16}
                width={16}
                alt={svgPath}
                src={svgPath}
            />
            <Typography variant="body1" lineHeight={1} color="inherit">
                {text}
            </Typography>
        </Box>
    )
}

export default BoxIconWithText