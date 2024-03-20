<?php

// https://phpstan.org/

/**
 * Generic
 * 
 * @template T of object
 * @param class-string<T> $a
 * @param array<T> $b
 * 
 * @return T
 */
function classTemplate(string $a, $b): mixed
{
    return $a();
}

/**
 * array generics and shape
 * 
 * @param non-empty-array<string> $list
 * @param array<string, int> $set
 * @param array{int, string} $tuple
 * @param array{a: int, b?: string} $options
 */
function arrayTemplate(array $list, array $set, array $tuple, array $options){}

/**
 * callable typehint
 * @param callable(int $a, int=): (string|int) $f1 $a is requied, second parameter is optional, return string or int
 * @param callable(int ...$a): int $f2 both accept multiple variadic args
 * @param callable(float...): void $f3 both accept multiple variadic args
 */
function call(callable $f1, callable $f2, callable $f3) {}

class Mask {
    public const INT_A = 1;
    public const INT_B = 2;
    public const INT_C = 4;
}

class Type {
    public const INT_A = 1;
    public const INT_B = 2;
    public const INT_C = 3;

    public const TYPE = [
        'a' => self::INT_A,
        'b' => self::INT_B,
        'c' => self::INT_C,
    ];
}

/**
 * mask and const
 * 
 * @param int-mask<1, 2, 4> $mask1 accepts values that can be composed using | from the given integers, and 0
 * @param int-mask-of<Mask::INT_*> $mask2 accepts values from all constants on Foo that start with `INT_`
 * 
 * @param key-of<Type::TYPE> $constByKey accepts key of Type::TYPE
 * @param value-of<Type::TYPE> $constByValue accepts value of Type::TYPE
 */
function maskAndConst(int $mask1, int $mask2, string $constByKey, int $constByValue) {}
