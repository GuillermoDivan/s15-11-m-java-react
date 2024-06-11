import * as React from "react";
import { SelectChangeEvent } from "@mui/material/Select";
import { MenuItem, FormControl, Select, useTheme } from "@mui/material";
import { UseFormRegisterReturn } from "react-hook-form";
import { ICinema } from "@/store/cinema-store";

interface Props {
    register?: UseFormRegisterReturn,
    valueAndName?: string[],
    optionsValue?: ICinema[] | false,
    listTo?: string,
    currentValue?: any,
}

const InputSelected: any = ({ register, currentValue, valueAndName, optionsValue, listTo }: Props) => {
    const [selectedValue, setSelectedValue] = React.useState("empty")
    const { palette } = useTheme()
    const handleChange = (event: SelectChangeEvent) => setSelectedValue(event.target.value);
    React.useEffect(() => currentValue && setSelectedValue(currentValue))
    return (
        <FormControl sx={{
            width: 280, textTransform: "uppercase",
            "& fieldset": { borderColor: "rgba(255, 255, 255, 0.2)" },
            "&:hover fieldset": { borderColor: "rgba(255, 255, 255, 0.5)!important" }
        }}>
            <Select
                value={selectedValue}
                onChange={handleChange}
                color="warning"
                displayEmpty
                inputProps={{
                    ...register,
                    "aria-label": "Without label",
                    sx: { color: "var(--gray-color)", "&:hover": { color: "var(--gray-color)!important" } }
                }}
                sx={{ "& .MuiSelect-icon": { color: "var(--gray-color)" } }}

                MenuProps={{
                    PaperProps: {
                        sx: {
                            backgroundColor: "black",
                            color: "var(--gray-color)",
                            "& .MuiMenuItem-root": {
                                borderBottom: "solid 1px rgba(255, 255, 255, 0.15)",
                                backgroundColor: "inherit",
                                "&:hover": {
                                    color: "var(--white)",
                                    backgroundColor: "rgba(255, 255, 255, 0.1)",
                                },
                                "&.Mui-selected": { color: palette.warning.main, },
                                "&.Mui-disabled": { opacity: 0.75 },
                            },
                        },
                    },
                }}
            >
                <MenuItem value="empty" disabled>
                    <em>{listTo}</em>
                </MenuItem>

                {
                    valueAndName
                        ? valueAndName.map((value, i) => (
                            <MenuItem key={i} value={value}>
                                {value}
                            </MenuItem>))
                        :
                        optionsValue && optionsValue.length > 0
                            ? optionsValue.map(({ id, name }, i) => (
                                <MenuItem key={`${i}-${id}`} value={id}>{name}</MenuItem>
                            ))
                            : <MenuItem disabled>Cargando opciones...</MenuItem>
                }

            </Select>
        </FormControl >
    );


}


export default InputSelected