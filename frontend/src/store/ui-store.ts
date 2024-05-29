import { createWithEqualityFn } from 'zustand/traditional'

interface IUseMenuState {
    isSideMenuOpen: boolean;
    openSideMenu: () => void;
    closeSideMenu: () => void;
    layoutBackgroundColor: string;
}

export const useMenuState = createWithEqualityFn<IUseMenuState>(set => ({
    isSideMenuOpen: false,
    openSideMenu: () => set({ isSideMenuOpen: true }),
    closeSideMenu: () => set({ isSideMenuOpen: false }),
    layoutBackgroundColor: "#000"
}))