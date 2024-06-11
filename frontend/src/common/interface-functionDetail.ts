

export interface ISeat {
    currentUser: null | string,
    functionDetailsId: string,
    id: string,
    occupied: boolean,
    reservationTime: null | string,
    seatEnum: string,
    seatNumber: string,
    ticket: null | string
}



export default interface IFunctionDetail {
    movieId: string;
    schedule: string;
    screenId: string;
    seatsList: ISeat[]
}
