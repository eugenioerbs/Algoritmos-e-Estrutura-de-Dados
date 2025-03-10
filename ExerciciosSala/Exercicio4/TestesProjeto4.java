/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

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
public class TestesProjeto4 {

    public TestesProjeto4() {
    }

    @Test
    public void Test01() {
        ListDupla<Integer> lista = new ListDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoListaDupla no5 = lista.buscar(5);
        NoListaDupla no10 = lista.buscar(10);
        NoListaDupla no15 = lista.buscar(15);
        NoListaDupla no20 = lista.buscar(20);

        assertEquals(15, no20.getProximo().getInfo());
        assertEquals(10, no15.getProximo().getInfo());
        assertEquals(5, no10.getProximo().getInfo());
    }

    @Test
    public void Test02() {
        ListDupla<Integer> lista = new ListDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoListaDupla no20 = lista.buscar(20);

        assertEquals(20, no20.getInfo());
    }

    @Test
    public void Test03() {
        ListDupla<Integer> lista = new ListDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoListaDupla no10 = lista.buscar(10);

        assertEquals(10, no10.getInfo());
    }

    @Test
    public void Test04() {
        ListDupla<Integer> lista = new ListDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(20);
        NoListaDupla no5 = lista.buscar(5);
        NoListaDupla no10 = lista.buscar(10);
        NoListaDupla no15 = lista.buscar(15);

        assertNull(no5.getProximo());
        assertEquals(10, no15.getProximo().getInfo());
        assertEquals(5, no10.getProximo().getInfo());
    }

    @Test
    public void Test05() {
        ListDupla<Integer> lista = new ListDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(10);
        NoListaDupla no5 = lista.buscar(5);
        NoListaDupla no15 = lista.buscar(15);
        NoListaDupla no20 = lista.buscar(20);

        assertEquals(15, no20.getProximo().getInfo());
        assertEquals(5, no15.getProximo().getInfo());
        assertNull(no5.getProximo());
    }

    @Test
    public void Test07() {
        ListDupla<Integer> lista = new ListDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.liberar();
        
        assertNull(lista.getPrimeiro());
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
