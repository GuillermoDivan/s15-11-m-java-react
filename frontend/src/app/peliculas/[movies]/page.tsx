import { Box, Button, Typography } from "@mui/material";
import type { Metadata } from "next";
import Link from "next/link";
import dynamic from "next/dynamic";
import Loader from "@/components/atoms/Loader";

const MovieFilters = dynamic(() => import("@/components/organism/MovieFilters"), { ssr: false })
const MoviePagination = dynamic(() => import("@/components/atoms/MoviePagination"), { ssr: false })

const PlayingNow = dynamic(() => import("@/components/organism/PlayingNow"), { ssr: false, loading: () => <Loader /> })
const ComingSoon = dynamic(() => import("@/components/organism/ComingSoon"), { ssr: false, loading: () => <Loader /> })

export const metadata: Metadata = {
    title: "Peliculas"
};

interface IProps {
    params: {
        movies: "en-pantalla" | "proximamente"
    },
    searchParams: {
        title: string
    }
}

const Page = ({ params }: IProps) => {
    const { movies } = params
    const inComingSoon = movies == "proximamente"

    if (movies != "en-pantalla" && !inComingSoon) return <h1 style={{ margin: "auto", textAlign: "center" }}>404 - Not Found</h1>

    return (<>
        <Box component="div" width="95%" m="2.5rem auto" display="flex" alignItems="center" gap="1rem"
            sx={{ flexDirection: { xs: "column", md: "row" }, justifyContent: { xs: "center", md: "space-between" } }}>

            <Typography variant="h3" textAlign={{ xs: "center", md: "left" }} children="Peliculas" />

            <Box component="div" textAlign="center">
                <Button color="warning" variant={!inComingSoon ? "contained" : "outlined"} LinkComponent={Link} href={inComingSoon ? "en-pantalla" : "#"}
                    children="en pantalla"
                    sx={{
                        height: "53px", fontWeight: 700, borderRadius: "8px 0 0 8px",
                        color: !inComingSoon ? "var(--black)" : "",
                    }} />

                <Button color="warning" variant={inComingSoon ? "contained" : "outlined"} LinkComponent={Link} href={!inComingSoon ? "proximamente" : "#"}
                    children="proximamente"
                    sx={{
                        height: "53px", fontWeight: 700, borderRadius: "0 8px 8px 0",
                        color: inComingSoon ? "var(--black)" : "",
                    }} />
            </Box>
        </Box>

        {!inComingSoon && <MovieFilters />}

        <Box sx={{ display: "flex", flexWrap: "wrap", gap: { xs: "20px 0", sm: "16px" }, justifyContent: "space-evenly" }} mb="3.5rem" >
            {inComingSoon ? <ComingSoon /> : <PlayingNow />}
        </Box>

        {inComingSoon && <MoviePagination />}
    </>)
}

export default Page