import './App.css'

import Registration from './registration'

function App() {

  return (
    <>
      <header></header>
        <main> 
          <div className="card">
            <aside>
                  <input type="text" className="search" id="search" name="search" placeholder="Search"/>
            </aside>
          </div>
          <section>
              <Registration/>
          </section>
        </main>
    </>
  )
}

export default App
