export const filterMovies = (res: Array<any>) => res.filter(movie =>
    movie.genre.length > 0 &&
    movie.image &&
    new Date(movie.releaseDate) > new Date()
);

export const convertGenre = (genreArray: Array<string>) => genreArray.join(", ").toLowerCase()

export const convertImagePath = (description: string, imagePath: string) => {
    const onlyPath = description.split("_face");
    return onlyPath[0] + "_face" + imagePath;
};


export const filterLastMovies = (res: Array<any>) => res.filter(movie =>
    movie.genre.length > 0 &&
    movie.image &&
    new Date(movie.releaseDate) < new Date()
);