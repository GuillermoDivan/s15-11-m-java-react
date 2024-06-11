import { MenuItem, ListItemIcon } from '@mui/material'
import Image from 'next/image'
import Link from 'next/link'
import { Fragment, FC } from 'react'

const AuthMenuItems: FC<{ handleClick: VoidFunction }> = ({ handleClick }) => {
    return (<Fragment>
        <MenuItem onClick={handleClick}>
            <ListItemIcon>
                <Image src={`/images/header/login-icon.svg`} alt={"login-icon"} width={22} height={22} />
            </ListItemIcon>
            <Link href="/usuario/iniciar-sesion" style={{ width: "100%" }}>
                Iniciar Sesión
            </Link>
        </MenuItem>
        <MenuItem onClick={handleClick}>
            <ListItemIcon>
                <Image src={`/images/header/register-icon.svg`} alt={"register-icon"} width={22} height={22} />
            </ListItemIcon>
            <Link href="/usuario/registro" style={{ width: "100%" }}>
                Registrarme
            </Link>
        </MenuItem>
    </Fragment>)
}

export default AuthMenuItems