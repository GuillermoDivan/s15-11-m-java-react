"use client"
import React, { useEffect, useState } from 'react';
import ReturnSeatsPopup from '../atoms/ReturnSeatsPopup';
import { fetchData } from '../../utils/fetchData';  // Asegúrate de importar la función fetchData correctamente
import { useAuthStore } from "@/store/auth-store"; // Ajusta la ruta según tu estructura de proyecto

interface Ticket {
  id: string;
  userId: string;
  cinemaName: string;
  screenName: string;
  movieName: string;
  seatsIds: string[];
  functionDate: string;
  value: number;
  active: boolean;
}


const TicketList: React.FC = () => {
  const [tickets, setTickets] = useState<Ticket[]>([]);
  const [selectedTicket, setSelectedTicket] = useState<Ticket | null>(null);
  const [showPopup, setShowPopup] = useState(false);
  const { jwt, isLogged, userId } = useAuthStore(state => ({
    jwt: state.jwt,
    isLogged: state.isLogged,
    userId: state.id
  }));

  useEffect(() => {
    const fetchTickets = async () => {
      const response = await fetchData(`ticket/u/${userId}`, 'GET', undefined, jwt);
      if (!response.error) {
        setTickets(response);
      } else {
        console.error(response.message);
      }
    };

    fetchTickets();
  }, []);
  

  const handleSelectTicket = (ticket: Ticket) => {
    setSelectedTicket(ticket);
    setShowPopup(true);
  };

  const handleClosePopup = () => {
    setShowPopup(false);
    setSelectedTicket(null);
  };

  const listStyle: React.CSSProperties = {
    display: 'grid',
    gridTemplateColumns: 'repeat(3, 1fr)',
    gap: '20px', // Espacio entre los elementos
    justifyContent: 'center', // Centra las filas horizontalmente
    padding: 0,
    listStyleType: 'none',
  };
  
  const ticketStyle: React.CSSProperties = {
    backgroundColor: '#333',
    color: '#fff',
    padding: '20px',
    margin: '0 auto', // Asegura que cada ticket esté centrado en su celda
    border: '2px solid #fff',
    borderRadius: '10px',
    boxShadow: '0 0 10px rgba(0, 0, 0, 0.5)',
    textAlign: 'center', // Centra el texto
  };
  
  const paragraphStyle: React.CSSProperties = {
    margin: '10px 0', // Ajusta el margen vertical
    fontSize: '1.1em', // Tamaño de la fuente (ajusta según necesidad)
  };
   const title: React.CSSProperties = {
    marginBottom: "30px", // Ajusta el margen vertical
    fontSize: '1.5em', // Tamaño de la fuente (ajusta según necesidad)
    textAlign: 'center', // Centra el texto

  };
  
  const buttonStyle: React.CSSProperties = {
    marginTop: '15px', // Espacio adicional entre los párrafos y el botón
    padding: '10px 20px', // Añadir padding para tamaño del botón
    backgroundColor: '#555', // Color de fondo del botón
    color: '#fff', // Color del texto del botón
    border: 'none', // Quita el borde por defecto del botón
    borderRadius: '5px', // Bordes redondeados para el botón
    cursor: 'pointer', // Cambia el cursor al pasar por el botón
  };
  
  return (
    <div>
      <h2 style={title}>Lista de tus Tickets</h2> 
      <ul style={listStyle}>
        {tickets.map(ticket => (
          <li key={ticket.id}>
            <div style={ticketStyle}>
              <p style={paragraphStyle}><strong>Película:</strong> {ticket.movieName}</p>
              <p style={paragraphStyle}><strong>Fecha y Hora:</strong> {ticket.functionDate}</p>
              <p style={paragraphStyle}><strong>Cine:</strong> {ticket.cinemaName}</p>
              <p style={paragraphStyle}><strong>Sala:</strong> {ticket.screenName}</p>
              <p style={paragraphStyle}><strong>Asientos:</strong> {ticket.seatsIds.length ? ticket.seatsIds.join(', ') : 'No asignados'}</p>
              <button style={buttonStyle} onClick={() => handleSelectTicket(ticket)}>Seleccionar</button>
            </div>
          </li>
        ))}
      </ul>
  
      {showPopup && selectedTicket && (
        <ReturnSeatsPopup 
          ticket={selectedTicket} 
          onClose={handleClosePopup} 
        />
      )}
    </div>
  );
  
  
  
};

export default TicketList;