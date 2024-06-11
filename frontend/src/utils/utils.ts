import { ISeat } from "@/common/interface-functionDetail";

export function priceFormat(numero: number): string {
    return `$ ${numero.toLocaleString('es-AR')}`;
}

export const sortSeats = (seats: ISeat[]): ISeat[] => {
    return seats.sort((a, b) => {
        const [rowA, colA] = [a.seatNumber.charAt(0), parseInt(a.seatNumber.substring(1))];
        const [rowB, colB] = [b.seatNumber.charAt(0), parseInt(b.seatNumber.substring(1))];

        if (rowA === rowB) {
            return colA - colB;
        } else {
            return rowA.localeCompare(rowB);
        }
    });
};
