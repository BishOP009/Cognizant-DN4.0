import logo from './logo.svg';
import './App.css';
import { CalculatorScore } from './components/CalculatorScore';

function App() {
  return (
    <div className="App">
    <CalculatorScore name={"Ayanava"} school={"WGS Patuli"} total={945} goal={10} />
    </div>
  );
}

export default App;
