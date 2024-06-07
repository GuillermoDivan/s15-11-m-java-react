"use client";
import { useState, useEffect, ChangeEvent, FormEvent } from 'react';
import CalificationStar from '../atoms/CalificationStar';
import { fetchData } from '../../utils/fetchData';
import { useAuthStore } from "@/store/auth-store"; // Ajusta la ruta según tu estructura de proyecto
import { Rating } from '@mui/material';

const CommentList: React.FC<{ id: string }> = ({ id }) => {
  const [comments, setComments] = useState<{ comment: string, userRate: number }[]>([]);
  const [newComment, setNewComment] = useState<string>('');
  const [newRating, setNewRating] = useState<number>(0);
  const [isClient, setIsClient] = useState(false);
  const [hasPurchasedTicket, setHasPurchasedTicket] = useState(true);

  // Recupera el token y el estado de autenticación desde el store
  const { jwt, isLogged, userId } = useAuthStore(state => ({
    jwt: state.jwt,
    isLogged: state.isLogged,
    userId: state.id
    
  }));

  useEffect(() => {
    setIsClient(true);

    const fetchComments = async () => {
      const data = await fetchData(`comment/allm/${id}/${true}`, 'GET', undefined, jwt);
      setComments(data);
    };

    ///ticket/u/{userId}/{active}
    const checkTicketPurchase = async () => {
      const data = await fetchData(`ticket/u/${userId}/${false}`, 'GET', undefined, jwt);
      setHasPurchasedTicket(data.hasPurchased);
    };

    fetchComments();
    checkTicketPurchase();
  }, [id, jwt, userId]);

  const handleCommentChange = (event: ChangeEvent<HTMLTextAreaElement>) => {
    setNewComment(event.target.value);
  };

  const handleRatingChange = (rating: number) => {
    setNewRating(rating);
  };

  const handleCommentSubmit = async (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    if (newComment.trim() !== '') {
      const commentData = {
        userId,
        movieId: id, 
        comment: newComment,
        userRate: newRating,
      };

      const data = await fetchData(`comment/create`, 'POST', commentData, jwt);
      if (data.success) {
        setComments([...comments, data.comment]);
        setNewComment('');
        setNewRating(0);
      } else {
        console.log(data.message);
      }
    }
  };

  if (!isClient) {
    return <div>Cargando...</div>;
  }

  return (
    <div>
      <h1>Comentarios de la Película</h1>
      {isLogged ? (
        hasPurchasedTicket ? (
          <form onSubmit={handleCommentSubmit}>
            <textarea
              value={newComment}
              onChange={handleCommentChange}
              placeholder="Escribe tu comentario aquí..."
              rows={4}
              cols={50}
            />
            <br />
            <CalificationStar active={true} vote_average={newRating} />
            <button type="submit">Agregar comentario</button>
          </form>
        ) : (
          <p>Debes haber comprado un ticket y visto la película para dejar un comentario.</p>
        )
      ) : (
        <p>Debes estar autenticado para dejar un comentario.</p>
      )}
      
      <div>
        {comments.length > 0 ? (
          comments.map((comment, index) => (
            <div key={index} style={{ marginBottom: '10px' }}>
              <p>{comment.comment}</p>
              <Rating value={comment.userRate} readOnly precision={0.5} size="small" />
            </div>
          ))
        ) : (
          <p>No hay comentarios disponibles.</p>
        )}
      </div>
    </div>
  );
};

export default CommentList;
