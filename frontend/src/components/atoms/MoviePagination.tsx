"use client"
import { useMoviesPagination } from "@/store/cspagination-store";
import Pagination from "@mui/material/Pagination";
import { shallow } from "zustand/shallow";

const MoviePagination = () => {
    const { page, setPage, totalPages } = useMoviesPagination(state => ({
        page: state.page,
        setPage: state.setPage,
        totalPages: state.totalPages
    }), shallow)
    const handleChangePage = (event: React.ChangeEvent<unknown>, value: number) => {
        setPage(value);
        window.scrollTo({ top: 0, behavior: "smooth" })
    }


    return <Pagination sx={{
        bgcolor: "var(--lightBlack)", width: { xs: "100%", sm: "80%" }, m: "2rem auto",
        "& .MuiPagination-ul": {
            justifyContent: "space-between",
            flexWrap: "nowrap",
            "& .MuiPaginationItem-root": {
                color: "white"
            },
            "& .Mui-selected, .Mui-selected:hover": {
                bgcolor: "var(--yellow)",
                color: "var(--black)"
            },
            "& .MuiPaginationItem-ellipsis": {
                display: { xs: "none", sm: "inline-block" }
            },
            "& .MuiPaginationItem-root:not(.Mui-selected):hover": {
                bgcolor: "rgba(255, 255, 255, 0.2)"
            },
        }
    }} size="large" count={totalPages} page={page} onChange={handleChangePage} />

}

export default MoviePagination