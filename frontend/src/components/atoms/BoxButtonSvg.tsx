import { Theme } from "@emotion/react";
import { Box, Button, SxProps } from "@mui/material"
import Image from "next/image";
import { FC } from "react"

interface IBoxButtonSvgProps {
    handleClick: () => void,
    path: string,
    sizesInPx: { width: number; height: number },
    alt: string,
    sxBox?: SxProps<Theme>,
    sxButton?: SxProps<Theme>,
}

const BoxButtonSvg: FC<IBoxButtonSvgProps> = ({ handleClick, path, sizesInPx, alt, sxBox, sxButton }) => {
    return (
        <Box color="inherit" sx={sxBox }>
            <Button onClick={handleClick} sx={sxButton}>
                <Image src={path}
                    width={sizesInPx.width}
                    height={sizesInPx.height}
                    alt={alt} />
            </Button>
        </Box>)
}

export default BoxButtonSvg