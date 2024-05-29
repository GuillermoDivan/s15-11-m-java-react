import TextField from '@mui/material/TextField';
import * as React from "react";
import { UseFormRegisterReturn } from "react-hook-form";
import { Theme } from "@emotion/react";

import { Box, Button, SxProps } from "@mui/material"
interface IInputMuiProps {
  inputName: string;
  inputType?: React.InputHTMLAttributes<unknown>['type'];
  inputLabel?: string;
  inputRequired?: boolean;
  inputRegister?: UseFormRegisterReturn;
  inputHelperText?: string;
  inputError?: boolean;
  inputSx?: SxProps<Theme>;
}

const InputMui: React.FC<IInputMuiProps> = ({ inputHelperText, inputError, inputRequired, inputRegister, inputName, inputType, inputLabel, inputSx }) => {
  return (
    <TextField
      {...inputRegister}
      required={inputRequired ?? false}
      error={inputError}
      id={inputName}
      name={inputName}
      autoComplete="off"
      type={inputType ?? inputName}
      label={inputLabel || false}
      helperText={inputError ? inputHelperText : false}
      variant={"filled"}
      color="warning"
      inputProps={{ sx: { color: "var(--white)" } }}
      sx={{
        ...inputSx,
        bgcolor: "var(--black)",
        "&:hover": { bgcolor: "var(--lightBlack)" },
        "& > label": { color: "var(--gray-color)" }
      }}
    />
  );
}

export default InputMui