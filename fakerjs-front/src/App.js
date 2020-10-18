import React, {useState} from "react";
import "./App.css";
import Button from 'react-bootstrap/Button';
import 'bootstrap/dist/css/bootstrap.min.css';
import Form from 'react-bootstrap/Form'
import faker from "faker"

function App() {

  const [registerData, setRegisterData] = useState([]);
  const [loginData, setLoginData] = useState([]);
  const [todoData, setTodoData] = useState([]);
  
  const generateRegister = () =>{
    const data = {
      email : faker.internet.email(),
      user_name: faker.internet.userName(),
      password : faker.internet.password()
    }
    setRegisterData(
      [data]
    )
    setLoginData([])
    setTodoData([])
  }
  const generateLogin = () =>{
    const data = {
      email : faker.internet.email(),
      password : faker.internet.password()
    }
    setTodoData([])
    setRegisterData([])
    setLoginData(
      [data]
    )
  }
  const generateTodo = () =>{
    const data = {
      tags : faker.random.boolean(),
      title : faker.random.words(),
      notes : faker.random.words()
    }
    setRegisterData([])
    setLoginData([])
    setTodoData([
      data
    ])
  }
  const generateAll = () =>{
   setRegisterData([
    {
      email : faker.internet.email(),
      user_name: faker.internet.userName(),
      password : faker.internet.password()
    }
   ])
   setLoginData([
    {
      email : faker.internet.email(),
      password : faker.internet.password()
    }
   ])
   setTodoData([
     {
      tags : faker.random.boolean(),
      title : faker.random.words(),
      notes : faker.random.words()
     }
   ])
  }
  return (
    <div className="wrapper">
      Generar:
      <Button variant="dark" style={{marginTop:"10px", marginLeft:"10px"}} onClick={generateAll}>Todos los campos</Button>
      <Button variant="dark" style={{marginTop:"10px", marginLeft:"10px"}} onClick={generateRegister}>Registro</Button>
      <Button variant="dark" style={{marginTop:"10px", marginLeft:"10px"}} onClick={generateLogin}>Login</Button>
      <Button variant="dark" style={{marginTop:"10px", marginLeft:"10px"}} onClick={generateTodo}>To do's</Button>
      <div className="contentWrapper">
        {todoData.map(data => (
          <div>
          <Form>
            <Form.Group controlId="exampleForm.ControlTextarea1">
              <Form.Label>Title</Form.Label>
              <Form.Control type="Title" placeholder={data.title} readOnly as="textarea"/>
            </Form.Group>

            <Form.Group controlId="exampleForm.ControlTextarea1">
              <Form.Label>Notes</Form.Label>
              <Form.Control type="notes" placeholder={data.notes} readOnly as="textarea"/>
            </Form.Group>

            <Form.Group controlId="exampleForm.ControlTextarea1">
              <Form.Label>Date </Form.Label>
          <br/>
              {data.date}
            </Form.Group>
            

            <Form.Group controlId="formBasicCheckbox">
              <Form.Check type="checkbox" label="Has tags" defaultChecked={data.tags}/>
            </Form.Group>
            </Form>
            <hr class="dashed"/>
          </div>
        ))
        }
      </div>
          <div className="contentWrapper">
        {registerData.map(data => (
          <div>
          <Form>
            <Form.Group controlId="formBasicEmail">
              <Form.Label>Email address</Form.Label>
              <Form.Control type="email" placeholder={data.email} readOnly/>
              <Form.Text className="text-muted">
                We'll never share your email with anyone else.
              </Form.Text>
            </Form.Group>

            <Form.Group controlId="formBasicEmail">
              <Form.Label>Username</Form.Label>
              <Form.Control type="username" placeholder={data.user_name} readOnly/>
            </Form.Group>

            <Form.Group controlId="formBasicEmail">
              <Form.Label>Password</Form.Label>
              <Form.Control type="email" placeholder={data.password} readOnly/>
            </Form.Group>
          </Form>
            <hr class="dashed"/>
          </div>
        ))
        }
      </div>
      <div className="contentWrapper">
        {loginData.map(data => (
          <div>
          <Form>
            <Form.Group controlId="formBasicEmail">
              <Form.Label>Email address</Form.Label>
              <Form.Control type="email" placeholder={data.email} />
              <Form.Text className="text-muted">
                We'll never share your email with anyone else.
              </Form.Text>
            </Form.Group>

            <Form.Group controlId="formBasicEmail">
              <Form.Label>Password</Form.Label>
              <Form.Control type="email" placeholder={data.password} />
            </Form.Group>
          </Form>
            <hr class="dashed"/>
          </div>
        ))
        }
      </div>
    </div>
  );
}

export default App;
