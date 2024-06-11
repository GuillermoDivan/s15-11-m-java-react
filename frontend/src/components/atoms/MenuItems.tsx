import { Avatar, Divider, ListItemIcon, MenuItem } from '@mui/material'
import Image from 'next/image'
import Link from 'next/link'
import { FC, Fragment } from 'react'

interface Props {
    handleClose: VoidFunction,
    logOut: VoidFunction,
    firstName: string,
}

interface Item {
    name: string
    path: string
    icon: string
}

const items: Item[] = [
    { name: "Mis Tickets", path: "/usuario/tickets", icon: "ticket-icon" },
    { name: "Mis Comentarios", path: "#", icon: "comment-icon" },
    { name: "Mis Beneficios", path: "#", icon: "gift-icon" },
]

const MenuItems: FC<Props> = ({ handleClose, firstName, logOut }) => {
    return (
        <Fragment>
            <MenuItem onClick={handleClose}>
                <Avatar sx={{ bgcolor: "var(--black)", color: "var(--gray-color)" }}>
                    {firstName.charAt(0)}
                </Avatar>
                Editar Perfil
            </MenuItem>

            {items.map(item => (
                <MenuItem onClick={handleClose} key={item.icon}>
                    <Link href={item.path}>
                    <ListItemIcon>
                        <Image src={`/images/header/${item.icon}.svg`} alt={item.icon} width={22} height={22} />
                    </ListItemIcon>
                    {item.name}
                    </Link>
                </MenuItem>
            ))}


            <Divider />
            <MenuItem onClick={() => {
                handleClose()
                logOut()
            }} sx={{ "&:hover": { bgcolor: "#ac00007d!important" } }}>
                <ListItemIcon>
                    <Image src={`/images/header/logout-icon.svg`} alt={"logout-icon"} width={22} height={22} />
                </ListItemIcon>
                Cerrar sesión
            </MenuItem>
        </Fragment>
    )
}

export default MenuItems