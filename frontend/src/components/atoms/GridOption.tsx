import { Button, Grid, Grow } from '@mui/material'
import { FC, PropsWithChildren } from 'react'

const GridOption: FC<PropsWithChildren<{ state: boolean, handleClick: () => void }>> = ({ state, children, handleClick }) => (
    <Grid item xs={6} sm={4.5}>
        <Grow in={state} style={{ transformOrigin: '0 0 0' }}  {...(state ? { timeout: 1250 } : {})}  >
            <Button variant='outlined' color="warning" type="button" onClick={handleClick}
                sx={{
                    minHeight: "3.5rem",
                    width: "100%",
                    bgcolor: "var(--lightBlack)",
                    fontSize: "1.15rem",
                    fontWeight: "500",
                }}
            >
                {children}
            </Button>
        </Grow>
    </Grid>
)

export default GridOption