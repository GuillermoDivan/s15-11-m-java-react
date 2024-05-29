const ONE_DAY: number = 86400000

export const isItemExpired = (key: string, expiry: number): boolean => {
    const now = new Date();
    if (now.getTime() > expiry) {
        localStorage.removeItem(key);
        return true;
    }

    return false;
}

export const getItemLStorage = (key: string) => {
    const getItem = localStorage.getItem(key) || false
    if (!getItem) return false
    const itemToString: string = String(getItem)
    const jsonItemInLocalStorage = JSON.parse(itemToString)

    const checkItemDeleted = isItemExpired(key, jsonItemInLocalStorage.expiry)
    if (checkItemDeleted) return false

    return jsonItemInLocalStorage
}

export const setItemLStorage = (key: string, value: Object): void => {
    const date = new Date()

    const stringifyValue = JSON.stringify({ ...value, expiry: date.getTime() + ONE_DAY })
    
    localStorage.setItem(key, stringifyValue)
}       