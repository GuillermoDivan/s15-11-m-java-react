import { getItemLStorage, setItemLStorage } from '@/utils/localStorageConvert'
import { createWithEqualityFn } from 'zustand/traditional'

export interface ILoginUser {
    jwt: string | undefined,
    rol: string | undefined,
    id: string | undefined,
    firstName: string | undefined,
    lastName: string | undefined,
}

export interface IAuthStore extends ILoginUser {
    isLogged: boolean,
    message?: string | undefined,
}

type Actions = {
    logIn: (user: ILoginUser) => void
    logOut: () => void,
    setMessage: (newMsg: string) => void,
}

const initialState: IAuthStore = {
    jwt: undefined,
    rol: undefined,
    id: undefined,
    firstName: undefined,
    lastName: undefined,
    isLogged: false,
    message: ""
}

export const useAuthStore = createWithEqualityFn<IAuthStore & Actions>(set => {
    const isUserAlreadyLoggedOrInitialState = getItemLStorage("user") || initialState

    return ({
        ...isUserAlreadyLoggedOrInitialState,
        logIn: (user: ILoginUser) => {
            if (isUserAlreadyLoggedOrInitialState.isLogged) return
            const dataUser = {
                jwt: user.jwt,
                rol: user.rol,
                id: user.id,
                firstName: user.firstName,
                lastName: user.lastName,
                isLogged: true,
            }

            setItemLStorage("user", dataUser)
            set(dataUser)
        },
        logOut: () => {
            set(initialState)
            localStorage.removeItem("user")
            window.location.reload()
        },
        setMessage: (newMsg: string) => set({ message: newMsg })
    })
})