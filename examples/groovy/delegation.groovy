
void printName() {
    println "CORRECT!"
}

Closure myClosure = {
  name = 'Craig Burke'
  printName()
}

class NamePrinter {
  String name

  void printName() {
    println "My Name is ${name}!!!"
  }
}

myClosure.delegate = new NamePrinter()
myClosure.resolveStrategy = Closure.DELEGATE_FIRST
myClosure()