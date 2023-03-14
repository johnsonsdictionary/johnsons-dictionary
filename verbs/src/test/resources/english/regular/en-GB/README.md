# CSV Format

The CSV files contained within this directory are of the following form:

Field 1: String : word
Fields 2... : conjugation-key prefixed conjugation values

# Questions

* Why the inconsistency in dictionary listings for ise/ize endings and yse/yze endings ?

* I have both doxing and doxxing in this batch of verbs.  Which is the correct spelling 
- they don't appear to be in the dictionary.  It matters because one of the rules
for doubling letters says not to double the final letter if it's "x".

* I've removed eyewater/eyewatering as can't see it listed in OED as a verb, or eyewatering as an adjective (either with or without a hyphen). Is this correct?



# TODO

* Think about how to handle multiple variations of spelling for present participles:

(eg. cache: caching, cacheing or eye: eyeing, eying, or twinge: twinging, twingeing)


* Think about how to handle multiple variations of spelling for present participles,
along with their corresponding spelling changes for past tense and past participles.

ie. these are not just alternate spellings, but alternate spelling pairs.

eg. bus: (bused, busing) or (bussed, bussing)

* I've added an example of an americani(s/z?)ed verb stem that is now listed first
in the OED - aestheticize.

There were others in this batch of verbs:

alchemize,past_tense=alchemised,present_participle=alchemizing
allegorize,past_tense=allegorized,present_participle=allegorizing
americanize,past_tense=americanised,present_participle=americanizing
anaesthetize,past_tense=anaesthetized,present_participle=anaesthetizing

Does this now apply to all of this ise/ize verbs? (eg. demonise - from looking at this one perhaps it does?)

How about yse/yze verbs (eg. analyse/analyze).  These are listed as two separate entries.

* Add support for French-appropriated verbs like flambe, saute, ricochet, or German/US like pretzel ( which behave differently)