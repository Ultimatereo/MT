# Лабораторная работа №3. Использование автоматических генераторов анализаторов Bison и ANTLR

## Введение

Цель данной лабораторной работы — научиться пользоваться автоматическими генераторами анализаторов Bison и ANTLR.
Форма отчетности: программа и текстовый отчет. Средство автоматической генерации вы можете выбрать самостоятельно.
Рекомендуемые источники:
http://www.gnu.org/software/bison — Bison
http://www.antlr.org — ANTLR

## Задание

Придумайте примитивный функциональный язык программирования и реализуйте его трансляцию в императивный язык.

## Решение

Мною были придуманы два продвинутых языка программирования из двух миров. 
Из мира функционального программирования нас встречает Curl Joe.
Из мира императивного программирования нас встречает Phony.


### Что же доступно в Curl Joe?

- Синтаксис похож на язык Clojure ;)
- Это язык с динамической типизацией
- Поддерживает арифметические операции и операции сравнения
- Функции задаются с помощью defn, перегрузка недоступна на данный момент
- Есть возможность использовать уже написанные функции
- Также можно задать namespace с помощью команды ns

### Phony же это императивный язык с динамической типизацией с синтаксисом похожим на Python ;)