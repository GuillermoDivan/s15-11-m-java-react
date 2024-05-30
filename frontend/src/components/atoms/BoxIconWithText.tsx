import { Typography, Box, TypographyProps } from "@mui/material"
import Image from "next/image"
import { FC } from "react"

interface IBoxIconWithText {
    svgPath: string,
    text: string,
    leftText?: boolean,
    typographyProps?: TypographyProps;
}

const BoxIconWithText: FC<IBoxIconWithText> = ({ svgPath, text, leftText, typographyProps }) => {
    return (
        <Box component={"div"} display={"flex"} m={"4px"} justifyContent={leftText ? "flex-start" : "center"} textAlign={leftText ? "start" : "center"} gap={"7px"} alignItems="center">
            <Image
                height={16}
                width={16}
                alt={svgPath}
                src={svgPath}
            />
            <Typography textTransform="capitalize" variant="body1" component={"span"} {...typographyProps} lineHeight={1} >
                {text}
            </Typography>
        </Box>
    )
}

export default BoxIconWithText