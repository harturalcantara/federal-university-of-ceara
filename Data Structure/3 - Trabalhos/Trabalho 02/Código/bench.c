#include <stdio.h>
#include "bench.h"

/*====================================================================*/
/* Private definitions                                                */
/*====================================================================*/

/**
 * Timer type.
 */

typedef unsigned long long bench_t;

static inline bench_t cycles(void) {
	unsigned int hi, lo;
	__asm volatile ("rdtsc\n\t":"=a" (lo), "=d"(hi));
	return ((bench_t) lo) | (((bench_t) hi) << 32);
}

/**
 * Stores the time measured before the execution of the benchmark.
 */
static bench_t before;

/**
 * Stores the time measured after the execution of the benchmark.
 */
static bench_t after;

/**
 * Stores the sum of timings for the current benchmark.
 */
long long total;

/*====================================================================*/
/* Public definitions                                                 */
/*====================================================================*/

void bench_reset() {
	total = 0;
}

void bench_before() {
	before = cycles();
}

void bench_after() {
	long long result;
	after = cycles();
	result = (after - before);
	total += result;
}

void bench_compute(int benches) {
	total = total / benches;
}

void bench_print() {
	printf("%lld cycles\n", total);
	printf("\n");
}

unsigned long long bench_get_total() {
	return total;
}
