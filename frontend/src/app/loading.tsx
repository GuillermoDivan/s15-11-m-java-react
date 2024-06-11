import { Typography } from '@mui/material';
import React from 'react';

const Loading = () => {
    return (
        <Typography
            textAlign={"center"}
            alignContent={"center"}
            m={"auto"}
            variant="h4"
            component="p"
            color={"var(--light-gray-color)"}
            gutterBottom
            sx={{
                display: "block",
                fontFamily: "monospace",
                whiteSpace: "nowrap",
                borderRight: "4px solid var(--light-gray-color)",
                width: "13ch",
                animation: "typing 1.3s steps(11) infinite, blink 0.8s infinite step-end",
                overflow: "hidden",
                "@keyframes typing": {
                    "0%": { width: 0 },
                    "100%": { width: "13ch" },
                },
                "@keyframes blink": {
                    "50%": { borderColor: "transparent" }
                }
            }}
        >
            Cargando...
        </Typography>
    );
}

export default Loading;
