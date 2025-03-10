/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import codes.ListaEncadeada;
import codes.NoLista;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Usuario
 */
public class TesteProjeto3 {

    public TesteProjeto3() {
    }//construtor

    @Test
    public void Test01() {
        ListaEncadeada<Integer> elemento = new ListaEncadeada<>();
        assertTrue(elemento.estaVazia());
    }

    @Test
    public void Test02() {
        ListaEncadeada<Integer> elemento = new ListaEncadeada<>();
        elemento.inserir(5);
        assertTrue(elemento.estaVazia());
    }

    @Test
    public void Test03() {
        ListaEncadeada<Integer> elemento = new ListaEncadeada<>();
        elemento.inserir(5);
        NoLista<Integer> primeiroNo = elemento.obterNo(0);
        assertNotNull(primeiroNo);
        assertEquals(5, primeiroNo.getInfo());
        assertNull(primeiroNo.getProximo());
    }

    @Test
    public void Test04() {
        ListaEncadeada<Integer> elemento = new ListaEncadeada<>();
        elemento.inserir(5);
        elemento.inserir(10);
        elemento.inserir(15);
        assertEquals(3, elemento.obterComprimento());
        assertEquals(15, elemento.obterNo(0).getInfo());
        assertEquals(10, elemento.obterNo(1).getInfo());
        assertEquals(5, elemento.obterNo(2).getInfo());
    }

    @Test
    public void Test05() {
        ListaEncadeada<Integer> elemento = new ListaEncadeada<>();
        elemento.inserir(5);
        elemento.inserir(10);
        elemento.inserir(15);
        elemento.inserir(20);
        NoLista<Integer> noBuscado = elemento.buscar(20);
        assertEquals(20, noBuscado.getInfo());
    }

    @Test
    public void Test06() {
        ListaEncadeada<Integer> elemento = new ListaEncadeada<>();
        elemento.inserir(5);
        elemento.inserir(10);
        elemento.inserir(15);
        elemento.inserir(20);
        NoLista<Integer> noBuscado = elemento.buscar(15);
        assertEquals(15, noBuscado.getInfo());
    }

    @Test
    public void Test07() {
        ListaEncadeada<Integer> elemento = new ListaEncadeada<>();
        elemento.inserir(5);
        elemento.inserir(10);
        elemento.inserir(15);
        elemento.inserir(20);
        NoLista<Integer> noBuscado = elemento.buscar(50);
        assertNull(noBuscado);
    }

    @Test
    public void Teste08() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(20);
        assertEquals(3, lista.obterComprimento());
        assertEquals(15, lista.obterNo(0).getInfo());
        assertEquals(10, lista.obterNo(1).getInfo());
        assertEquals(5, lista.obterNo(2).getInfo());
    }

    @Test
    public void Teste09() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(15);
        assertEquals(3, lista.obterComprimento());
        assertEquals(20, lista.obterNo(0).getInfo());
        assertEquals(10, lista.obterNo(1).getInfo());
        assertEquals(5, lista.obterNo(2).getInfo());
    }

    @Test
    public void Teste10() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        int noObtido = lista.obterNo(0).getInfo();
        assertEquals(20, noObtido);
    }

    @Test
    public void Teste11() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        int noObtido = lista.obterNo(3).getInfo();
        assertEquals(5, noObtido);
    }
    
    @Test
    public void Teste12() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lista.obterNo(10);
                });
    }
    
    @Test
    public void Teste13() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        int todosNos = lista.obterComprimento();
        assertEquals(0, todosNos);
    }
    

    
    

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
