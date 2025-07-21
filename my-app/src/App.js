import { useState } from 'react';

function ThemeToggle({ theme, onToggle }) {
  return (
    <button
      className="theme-toggle"
      onClick={onToggle}
      aria-label="Toggle dark/light mode"
    >
      <span className={`icon ${theme === 'dark' ? 'moon' : 'sun'}`}>
        {theme === 'dark' ? '🌙' : '☀️'}
      </span>
    </button>
  );
}
function Square({value, onSquareClick}) {
  return (
    <button className="square" onClick={onSquareClick}>
      {value}
    </button>
  );
}
function calculateWinner(squares) {
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6]
  ];
  for (const element of lines) {
    const [a, b, c] = element;
    if (
      squares &&
      squares[a] &&
      squares[a] === squares[b] &&
      squares[a] === squares[c]
    ) {
      return squares[a]; // Return the winner ('X' or 'O')
    }
  }
  return null; // Always return null if no winner
}


function Board({ xIsNext, squares, onPlay }) {
  function handleClick(i) {
    if (squares[i] || calculateWinner(squares)) {
      return; // Ignore click if square is already filled or if there's a winner
    }
    const nextSquares = squares.slice(); // Create a copy of the squares array
    nextSquares[i] = xIsNext ? 'X' : 'O'; // Set the clicked square to 'X' or 'O' based on the current player
    onPlay(nextSquares);
  }
  const winner = calculateWinner(squares);
  let status;
  status = winner ? `Winner: ${winner}` : `Next player: ${xIsNext ? 'X' : 'O'}`;
  return(
    <>
    <div className="status">{status}</div>
    <div className="board-row">
      <Square  value={squares[0]} onSquareClick={() => handleClick(0)} />
      <Square  value={squares[1]} onSquareClick={() => handleClick(1)} />
      <Square  value={squares[2]} onSquareClick={() => handleClick(2)} />
    </div>
    <div className="board-row">
      <Square  value={squares[3]} onSquareClick={() => handleClick(3)} />
      <Square  value={squares[4]} onSquareClick={() => handleClick(4)} />
      <Square  value={squares[5]} onSquareClick={() => handleClick(5)} />
    </div>
    <div className="board-row">
      <Square  value={squares[6]} onSquareClick={() => handleClick(6)} />
      <Square  value={squares[7]} onSquareClick={() => handleClick(7)} />
      <Square  value={squares[8]} onSquareClick={() => handleClick(8)} />
    </div>
    </>
    
  );
}
export default function Game() {
  const [history, setHistory] = useState([Array(9).fill(null)]);
  const [currentMove, setCurrentMove] = useState(0);
  const [theme, setTheme] = useState('dark');
  const xIsNext = currentMove % 2 === 0;
  const currentSquares = history[currentMove];

  function handlePlay(nextSquares) {
    const nextHistory = [...history.slice(0, currentMove + 1), nextSquares];
    setHistory(nextHistory);
    setCurrentMove(nextHistory.length - 1);
  }

  function jumpTo(move) {
    setCurrentMove(move);
  }

  function toggleTheme() {
    setTheme(theme === 'dark' ? 'light' : 'dark');
  }

  const moves = history.map((squares, move) => {
    const desc = move ? `Go to move #${move}` : 'Go to game start';
    return (
      <li key={move}>
        <button onClick={() => jumpTo(move)}>{desc}</button>
      </li>
    );
  });

  return (
    <div className={`game ${theme}`}>
      <ThemeToggle theme={theme} onToggle={toggleTheme} />
      <div className={`game-board ${theme}`}>
        <Board xIsNext={xIsNext} squares={currentSquares} onPlay={handlePlay} />
      </div>
      <div className={`game-info ${theme}`}>
        <ol>{moves}</ol>
      </div>
    </div>
  );
}