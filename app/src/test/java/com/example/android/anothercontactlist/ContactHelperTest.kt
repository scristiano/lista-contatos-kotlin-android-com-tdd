package com.example.android.anothercontactlist

import android.content.Context
import android.content.SharedPreferences
import androidx.test.core.app.ApplicationProvider
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(RobolectricTestRunner::class)
class ContactHelperTest {
    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val sharedPreferences:SharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    private val contactHelper = ContactHelper(sharedPreferences)
    @Test
    fun `Quando chamar o metodo getListContacts() com 2 contatos, deve retornar uma lista de 2 contatos` (){
        // Prepara o teste
        mockListaDoisContatos()

        // Valida o teste
        val list = contactHelper.getListContacts()
        assertEquals(2, list.size)
    }

    @Test
    fun `Quando chamar o metodo getListContacts() sem contatos, deve retornar uma lista vazia` (){
        // Prepara o teste
        mockListaContatosVazia()
        // Valida o teste
        val list = contactHelper.getListContacts()
        assertEquals(0, list.size)

    }

    private fun mockListaDoisContatos(){
        contactHelper.setListContacts(
            arrayListOf(
                Contact(
                    "Igor Ferrani",
                    "(00) 8000-0000",
                    "img.jpg"
                ),
                Contact(
                    "José Alves",
                    "(99) 9999-9999",
                    "img.jpg"
                )
            )
        )

    }

    private fun mockListaContatosVazia(){
        contactHelper.setListContacts(arrayListOf())
    }
}