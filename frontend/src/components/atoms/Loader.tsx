import { Box } from "@mui/material"

const Loader = () => {
    return (
        <Box sx={{
            margin:"1rem auto",
            width: "120px",
            height: "120px",
            borderRadius: "50%",
            animation: "spin 1.2s linear infinite",
            "&::before, &::after": {
                content: '""',
                position: "absolute",
                borderRadius: "inherit"
            },
            "&::before": {
                width: "100%",
                height: "100%",
                backgroundImage: "linear-gradient(var(--yellow) 0%, #fcf2d98c 100%)"
            },
            "&::after": {
                width: "85%",
                height: "85%",
                bgcolor: "var(--black)",
                top: "50%",
                left: "50%",
                transform: "translate(-50%, -50%)"
            },
            "@keyframes spin": {
                to: {
                    transform: "rotate(360deg)"
                }
            }
        }}>
        </Box>
    )
}

export default Loader