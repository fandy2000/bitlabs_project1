package com.afanditaufik

import entity.MagicWeapon
import entity.Weapon
import java.util.*


var scanner = Scanner(System.`in`)
//Membuat Collection #4
var listWeapon = mutableListOf<Weapon>()
var listMagicWeapon  = mutableListOf<MagicWeapon>()
//val choose : Int = 0

fun main(){ //Membuat Logic Main Menu #2/10
    initWeapon()
    do {
        initMenu()
        val menu = scanner.nextInt()
        scanner.nextLine()
        when (menu){
            1 ->createdItem()
            2 ->viewItem()
            3 ->updateItem()
            4 ->deleteItem()

        }
    }while (menu !=5)
}
fun initMenu(){
    println(" Welcome to Fandy's Store Admin Panel ")
    println("=======================================")
    println("1. Create Menu")
    println("2. View Item")
    println("3. Update Item")
    println("4. Delete Item")
    println("5. exit")
    print("Choose Menu: ")

}

//update git
fun initWeapon(){
    val weapon = Weapon()
    weapon.name = "M 24"
    weapon.damage = 89
    listWeapon.add(weapon)

    val swordWeapon = Weapon()
    swordWeapon.name = "Shotgun"
    swordWeapon.damage = 65
    listWeapon.add(swordWeapon)

    val awmWeapon = Weapon()
    awmWeapon.name = "AWM"
    awmWeapon.damage = 132
    listWeapon.add(awmWeapon)



    val magicWeapon = MagicWeapon()
    magicWeapon.name = "flare gun"
    magicWeapon.damage = 43
    magicWeapon.magicDamage = 25
    listMagicWeapon.add(magicWeapon)
}
fun createdItem(){
    do {
        println("1. Weapon")
        println("2. Magic Weapon")
        print("Choose: ")
        val choose = scanner.nextInt()
        scanner.nextLine()

        when(choose){
            1 ->{
                val weaponKu = Weapon()
                print("Weapon's Name: ")
                weaponKu.name = scanner.nextLine()
                print("Weapon's Damage: ")
                weaponKu.damage = scanner.nextInt()
                scanner.nextLine()
                listWeapon.add(weaponKu)
                println()
            }
            2 ->{
                var magicWeaponBgt = MagicWeapon()
                print("Weapon's Name: ")
                magicWeaponBgt.name = scanner.nextLine()
                print("Weapon's Damage: ")
                magicWeaponBgt.damage = scanner.nextInt()
                print("Weapon's Magic Damage: ")
                magicWeaponBgt.magicDamage = scanner.nextInt()
                scanner.nextLine()
                listMagicWeapon.add(magicWeaponBgt)
                println()
            }
            else -> {
                println("Choose 1 or 2")
            }
        }

    } while (choose > 2)
}

fun viewItem(){
    do {
        println("1. Weapon")
        println("2. Magic Weapon")
        print("Choose: ")
        val choose = scanner.nextInt()
        scanner.nextLine()
        when (choose){
            1 ->{
                viewWeapon()
            }
            2 ->{
                viewMagicWeapon()
            }
        }
    } while (choose > 2)
}


fun deleteItem() {
    do {
        println("1. Weapon")
        println("2. Magic Weapon")
        print("Choose: ")
        var choose = scanner.nextInt()
        scanner.nextLine()
        when(choose) {
            1 -> {
                viewWeapon()
                print("Choose Weapon You Want to delete: ")
                val chooseDelete = scanner.nextInt()
                scanner.nextLine()
                listWeapon.removeAt(chooseDelete-1)
            }
            2 -> {
                viewMagicWeapon()
                print("Choose Magic Weapon You Want to delete: ")
                val chooseDelete = scanner.nextInt()
                scanner.nextLine()
                listMagicWeapon.removeAt(chooseDelete-1)
            }
        }
    } while (choose > 2)
}
fun updateItem(){
    do {
        println("1. Weapon")
        println("2. Magic Weapon")
        print("Choose: ")
        val choose = scanner.nextInt()
        scanner.nextLine()
        when (choose){
            1 ->{
                viewWeapon()
                do {
                    print("Choose Weapon: ")
                    val chooseWeapon = scanner.nextInt()
                    scanner.nextLine()
                    val weapon = listWeapon[chooseWeapon-1]
                    print("Weapon's Name: ")
                    weapon.name = scanner.nextLine()
                    print("Weapon's Damage: ")
                    weapon.damage = scanner.nextInt()
                    scanner.nextLine()
                    println()
                } while (chooseWeapon > listWeapon.size)
            }
            2 ->{

                viewMagicWeapon()
                do {
                    print("Choose Magic Weapon: ")
                    val chooseMagicWeapon = scanner.nextInt()
                    scanner.nextLine()
                    val magicWeapon = listMagicWeapon[chooseMagicWeapon-1]
                    print("Weapon's Name: ")
                    magicWeapon.name = scanner.nextLine()
                    print("Weapon's Damage: ")
                    magicWeapon.damage = scanner.nextInt()
                    scanner.nextLine()
                    print("Weapon's Magic Damage: ")
                    magicWeapon.magicDamage = scanner.nextInt()
                    scanner.nextLine()
                    println()
                } while (chooseMagicWeapon > listMagicWeapon.size)
            }
        }

    }while (choose > 2)
}
fun viewWeapon(){
    println("Weapon")
    listWeapon.forEachIndexed { index, element ->
        println("======================================")
        println("no  || Weapon  ||   Damage   ||    ")
        println("======================================")
        println("${index + 1}.      ${element.name}         ${element.damage}")
        println("===================================")
    }
}
fun viewMagicWeapon(){
    println("Magic Weapon")
    println("======================================")
    listMagicWeapon.forEachIndexed { index, element ->
        println(" no    Weapon     Damage      Magic ")
        println("${index + 1}.      ${element.name}        ${element.damage}        ${element.magicDamage}")
    }
}
